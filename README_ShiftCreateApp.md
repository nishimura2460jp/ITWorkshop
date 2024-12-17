# プロジェクト名

<div id="top"></div>
## INDEX

1. [プロジェクトについて](#プロジェクトについて)
2. [動作環境](#環境)
3. [デモ画面](#デモ画面)
4. [実行準備](#実行準備)

<!-- プロジェクトについて -->

## プロジェクトについて
SBキャリアカレッジ梅田校「Python/Javaプログラマー養成科」の授業の一環としてWebアプリケーションを作成しました。
・ターゲットユーザー： 管理者及びスタッフ
・アプリ導入による効果： 管理者:シフト作成時間の短縮、スタッフ:気軽に希望休の登録可能
・所感： 
<p align="right">(<a href="#top">トップへ</a>)</p>

## 環境

<!-- 言語、フレームワーク、ミドルウェア、インフラの一覧とバージョンを記載 -->
- バックエンド
    - java
    - H2 Database
    - Apache Tomcat (Tomcat10_Java21)
- フロントエンド
    - HTML
    - CSS

<p align="right">(<a href="#top">トップへ</a>)</p>

## デモ画面
![TOP](xxxx.jpg)<br>
【トップ画面】スタート画面です。<br>

![TEST](xxxx.jpg)<br>
【設定画面】設定の画面です。（初期設定：通所介護事業所）<br>

![RESULT](xxx.jpg)<br>
【結果画面】シフト作成結果画面です。 <br>

<p align="right">(<a href="#top">トップへ</a>)</p>


## 実行準備
1.Githubからリポジトリをクローン
2.Eclipseに「ShiftCreateApp」をインポート
3.H2 Databaseで「shiftCreate.mv.db」を読み込み
4.Tomcat10_Java21で「WelcomeServlet」を実行

<p align="right">(<a href="#top">トップへ</a>)</p>