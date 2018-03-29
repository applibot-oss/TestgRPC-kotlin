# TestgRPC-kotlin
kotlinでのgRPC検証サンプルソース

## 動作環境
* Kotlin 1.2.30
* Apache Tomcat/8.5.28

## 検証方法
1. ./gradlew buildでビルド
2. ./gradlew bootRunで実行
3. [クライアント](https://github.com/applibot-inc/TestgRPC-unity)からリクエストが届いたときに、そのときのUnix時間をテキストファイルに保存
4. 保存されたサーバー側のUnix時間と、クライアント側で保存されているリクエスト、レスポンス時のUnix時間を用いて速度を計算する
