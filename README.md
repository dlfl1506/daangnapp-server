# 당근마켓 앱 클론 프로젝트

### 의존성

- Sring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Web

### 외부라이브러리
- proj 1.06.jar
- javaSDK 2.2.jar

### 데이터베이스
```sql
create user 'daangnapp'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'daangnapp'@'%';
create database daangnapp;
```

### yml 설정
```
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: utf-8
      enabled: true

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/daangnapp?serverTimezone=Asia/Seoul
    username: daangnapp
    password: bitc5600
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
    properties:
      hibernate.format_sql: true

  jackson:
    serialization:
      fail-on-empty-beans: false
```