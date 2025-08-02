# My ToDo List App

シンプルなToDoリスト管理アプリケーションです。
やることの追加、編集、削除、完了/未完了の管理ができます。

## 主な機能

-   **ToDoの追加**: 新しいToDo項目をリストに追加できます。
-   **ToDoの一覧表示**: 未完了のToDoを一覧で確認できます。
-   **ToDoの編集**: 登録済みのToDoの内容を修正できます。
-   **ToDoの削除**: 不要なToDo項目をリストから削除できます。
-   **完了/未完了の切り替え**: ToDoを完了状態にしたり、未完了に戻したりできます。
-   **完了済みToDoリスト**: 完了したToDoだけを別のページで確認できます。
-   **データ永続化**: アプリを再起動してもデータは消えません。

## 使用技術

-   **バックエンド**:
    -   Java 21 (JDK 21)
    -   Spring Boot (バージョン: 3.x.x)
    -   Spring Data JPA (データベース操作)
    -   H2 Database (開発用インメモリ/ファイルDB)
    -   Lombok (ボイラープレートコード削減)
    -   Validation (入力値のバリデーション)
-   **フロントエンド**:
    -   Thymeleaf (HTMLテンプレートエンジン)
    -   HTML5 / CSS3

## アプリケーションの起動方法

### 前提条件
-   Java Development Kit (JDK) 21以上がインストールされていること
-   Mavenがインストールされていること (またはMaven Wrapperを使用)

### 1. プロジェクトのクローン（ダウンロード）
```bash
git clone [https://github.com/ysk-tmt/todo-app.git](https://github.com/ysk-tmt/todo-app.git)
