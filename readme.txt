アプリケーション名「日々の些細な出来事や行いを記録する日記webアプリ」

使い方
①/indexから本文(200文字以内)を入力し、本文の種類、強調表示をするかを選択して送信ボタンを押すとDatabaseに記録されて表示されます。
②編集ボタンを押すと、選択した投稿文の本文、本文の種類、強調表示の有無を変更できます
強調表示は1or0で1にしているものは強制的に上の行に表示されます。それ以外の行は新しいものが上に表示され、古いものほど下に表示されます。

Databaseのユーザーネーム及びパスワードは以下の2つに入力する必要があります
src.main.resource.application.properties
src.main.java.com.example.diary.diary_Sql.DiaryConfig.java

開発環境
IDE visual studio code 1.89.1

javaバージョン17
springboot3.2.5

MySqlバージョン8.4
Database名はmy_database
以下はCreateTable文
CREATE TABLE MyDiary (Id INT PRIMARY KEY AUTO_INCREMENT, 
    tagString VARCHAR(10) NOT NULL,
    mainString VARCHAR(200) NOT NULL,
    dateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    emphasis INT);