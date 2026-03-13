# ==========================================
# 1단계: 빌드 스테이지 (Build Stage)
# 실제 소스코드를 컴파일하고 실행 가능한 JAR 파일을 만드는 과정입니다.
# ==========================================
# 빌드 도구와 JDK가 모두 포함된 무거운 이미지를 'build'라는 이름의 별칭으로 사용합니다.
FROM eclipse-temurin:21-jdk-jammy AS build

# 컨테이너 내부에서 작업이 진행될 디렉토리를 생성하고 이동합니다.
WORKDIR /app

# [빌드 최적화] 빌드 캐시를 활용하기 위해 설정 파일들을 먼저 복사합니다.
# 소스 코드가 바뀌어도 의존성(라이브러리)이 바뀌지 않았다면 이 단계는 캐시된 것을 재사용합니다.
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# gradlew 파일에 실행 권한을 부여하고, 필요한 라이브러리들을 미리 다운로드합니다.
# --no-daemon 옵션은 도커 환경에서 불필요한 백그라운드 프로세스 생성을 방지합니다.
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# 이제 실제 프로젝트 소스 코드 전체를 컨테이너로 복사합니다.
COPY . .

# [권한 설정] 복사된 파일 중 gradlew의 실행 권한을 다시 한번 확실히 보장합니다.
RUN chmod +x gradlew

# 테스트 코드를 제외(-x test)하고 실제 실행 가능한 JAR 파일을 빌드합니다.
RUN ./gradlew build -x test --no-daemon


# ==========================================
# 2단계: 실행 스테이지 (Run Stage)
# 빌드 결과물만 챙겨서 가벼운 환경으로 옮겨 실제 서비스를 실행합니다.
# ==========================================
# 실행 시에는 JDK 전체가 아닌 가벼운 JRE 환경이 포함된 Alpine 리눅스 이미지를 사용합니다.
# 이를 통해 최종 이미지 용량을 획기적으로 줄일 수 있습니다.
FROM eclipse-temurin:21-jdk-alpine

# 실행 시 작업 디렉토리를 설정합니다.
WORKDIR /app

# [중요] 1단계(build 스테이지)에서 생성된 결과물(.jar)만 선택해서 가져옵니다.
# /app/build/libs/ 내부의 빌드된 파일을 컨테이너의 /app/app.jar라는 이름으로 복사합니다.
COPY --from=build /app/build/libs/*.jar app.jar

# 컨테이너가 시작될 때 자동으로 실행될 명령어를 설정합니다.
# java -jar app.jar 명령어를 실행하여 스프링 부트 애플리케이션을 구동합니다.
ENTRYPOINT ["java", "-jar", "app.jar"]