# 1단계: 빌드 스테이지 (Build Stage)
# 빌드 시에는 툴이 많이 포함된 무거운 이미지를 사용해도 괜찮습니다.
FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /app

# 빌드 효율을 위해 소스 전체를 복사하기 전, 래퍼 파일만 먼저 복사해 레이어 캐싱 활용 가능
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# 의존성 먼저 다운로드 (선택 사항이나 빌드 속도 향상에 도움)
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# 나머지 소스 복사 및 빌드
COPY . .
RUN ./gradlew build -x test --no-daemon

# 2단계: 실행 스테이지 (Run Stage)
# 실행 시에는 가장 가볍고 보안이 강화된 alpine 이미지를 사용합니다.
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# 빌드 스테이지에서 생성된 jar 파일만 쏙 가져옵니다.
COPY --from=build /app/build/libs/*[!plain].jar app.jar

# 타임리프의 레이아웃이나 정적 리소스 처리를 위해 8080 포트 개방
EXPOSE 8080

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]