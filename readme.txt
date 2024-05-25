アプリケーション名「日々の些細な出来事や行いを記録する日記webアプリ」

仕様
①"/"ページから本文(200文字以内)を入力し、本文の種類、強調表示をするかを選択して送信ボタンを押すとDatabaseに記録されて表示されます。
②編集ボタンを押すと、選択した投稿文の本文、本文の種類、強調表示の有無を変更できます。
強調表示を有にすると強制的に上の行に表示されます。それ以外の行は新しいものが上に表示され、古いものほど下に表示されます。

MySQLに接続されなかった場合はHSQLBD(メモリで動くデータベース)に接続されます。

開発環境
IDE visual studio code 1.89.1
javaバージョン17.0.10
springboot3.2.5
MySqlバージョン8.4
HSQLDBバージョン2.7.2

Database名はmy_database
以下はCreateTable文
CREATE TABLE MyDiary (Id INT PRIMARY KEY AUTO_INCREMENT, 
    tagType VARCHAR(10) NOT NULL,
    mainString VARCHAR(200) NOT NULL,
    dateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    emphasis INT);