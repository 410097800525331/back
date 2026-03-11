# 스테이지 1: 빌드 환경
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew
# 빌드를 수행하여 jar 파일을 생성합니다.
RUN ./gradlew clean bootJar -x test

# 스테이지 2: 실행 환경
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# [수정 포인트] 복사 경로를 명확히 지정합니다. 
# 빌드 스테이지의 build/libs 폴더 안에서 가장 용량이 큰(실행 가능한) jar 파일을 app.jar로 가져옵니다.
COPY --from=build /app/build/libs/*.jar app.jar

# 만약 위 라인에서 에러가 난다면, 프로젝트 이름을 포함한 전체 경로를 써주는 것이 안전합니다.
# COPY --from=build /app/build/libs/sb.board.ex01-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 10000

# 컨테이너 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=10000"]