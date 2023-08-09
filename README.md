# Coffee_JSON_TEST

## Data를 JSON으로 던지기

```
Coffee(Batch)를 바탕으로 DataBase에 있는 데이터를 JSON으로 던지기
```

<br>

```
Jackson 라이브러리의 objectMapper 클래스의 writeValueAsString를 사용했습니다.<br>
writeValueAsString는 직렬화(Serialization)와 역직렬화(Deserialization) 기능이 있습니다.<br>

직렬화(Serialization)는 Java 객체를 JSON 형식으로 변환하는 작업입니다. 이때 객체의 데이터와 구조가 JSON 형태로 변환되어 저장되며,<br>
이를 통해 웹 API 응답을 생성하거나 파일에 데이터를 저장할 수 있습니다.<br>

역직렬화(Deserialization)는 반대로 JSON 데이터를 Java 객체로 변환하는 작업입니다.<br>
JSON 형식의 데이터를 읽어와 객체의 필드와 구조로 변환하여 사용할 수 있습니다.<br>
이를 통해 클라이언트가 보낸 JSON 요청을 서버에서 처리하거나, 저장된 JSON 데이터를 Java 객체로 변환하여 활용할 수 있습니다.<br>

```
