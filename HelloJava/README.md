# 読経サポートシステム (Sutra Viewer)

## 概要
PostgreSQLデータベースから経典を読み取り、CLIで読経体験を提供するJavaアプリケーションです。

## 機能
- 経典一覧の表示
- 句単位での読経表示
- ふりがな・補足情報の表示
- 読経速度の調整（3秒間隔）

## セットアップ

### 必要な環境
- Java 17以上
- PostgreSQL 12以上
- PostgreSQL JDBC Driver

### データベース設定
1. PostgreSQLに接続
2. データベース `d_kyouten` を作成
3. テーブル `t_kyos` と `t_verses` を作成
4. 経典データを挿入

### コンパイル・実行
```bash
# コンパイル
javac -cp "lib/*" -d bin src/SutraViewerCli/*.java

# 実行
java -cp "bin;lib/*" SutraViewerCli.Main
```

## 使用方法
1. アプリケーション起動
2. ユーザー名・パスワード入力
3. 利用可能な経典一覧を確認
4. 読経したい経典のIDを入力
5. 句単位で読経表示

## ファイル構成
```
src/SutraViewerCli/
├── Main.java          # メインアプリケーション
lib/
├── postgresql-42.7.6.jar  # PostgreSQL JDBC Driver
```

## 注意事項
- ローカルPostgreSQLデータベースが必要です
- データベース接続情報は実行時に入力してください
- 学習目的で作成されたアプリケーションです

## ライセンス
学習用プロジェクトのため、自由に使用・改変可能です。
