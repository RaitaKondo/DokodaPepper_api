# DokodaPepper API

DokodaPepper は、位置情報に基づいて投稿を共有・発見する SNS アプリケーションのバックエンド API です。本リポジトリはその Spring Boot 製 RESTful API 部分で構成されています。

---

## 🌏 特徴

- 📍 **位置情報ベースの投稿**  
  Google Geocoding API による緯度・経度 → 都道府県/市区町村の自動登録

- 🧭 **カテゴリ選択型の閲覧**  
  都道府県、市区町村別に投稿をフィルタリング

- 📝 **投稿・編集・削除**  
  画像付き投稿の作成、編集、削除、削除時の画像の自動削除（連続投稿制限、リクエストの権限確認あり）

- 💬 **コメント機能**  
  投稿へのコメント投稿・取得（連続投稿制限あり）

- 👀 **見つけた！ボタン機能**  
  投稿に対して "Found it!" のカウント・トグル

- 🖼️ **S3ストレージ連携**  
  投稿画像は AWS S3 に保存。Presigned URL による画像参照

- 🗃️ **セッションベースのログイン管理**  
  Spring Security + セッションストレージ による認証・自動ログイン対応

---

## 🛠️ 技術スタック

| 分類        | 使用技術                          |
|-------------|-----------------------------------|
| 言語        | Java 21, Spring Boot              |
| DB          | PostgreSQL                        |
| セキュリティ| Spring Security (セッション管理)  |
| 認証        | 自動ログイン付き登録・ログインAPI |
| インフラ    | Docker, Render.com                |
| 外部API     | Google Maps Geocoding API         |
| ストレージ  | AWS S3 (Presigned URL 対応)       |
| その他      | Gradle, Thymeleaf (一部テンプレート) |

---

2. `Dockerfile` および `Procfile` により自動ビルド＆起動

---

## 🔐 API 認証について

- `POST /api/register`：登録（成功時は自動ログイン）
- `POST /api/login`：ログイン（セッション保持）
- `POST /api/logout`：ログアウト（セッション破棄）

> 各投稿・編集APIは `@PreAuthorize("isAuthenticated()")` によって保護されています。

---

## 📌 今後の展望（例）

- 🔍 投稿検索（キーワード・タグなど）
- 🔔 通知機能
- 📊 投稿分析（人気投稿ランキング）

---

## 📄 ライセンス

MIT License（予定）

---

## 🧑‍💻 フロントエンドとの連携

本 API は React TypeScript 製のフロントエンド [dokodapepper_front_type](https://github.com/RaitaKondo/DokodaPepper_front_type) と連携して動作します。

