<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成アプリ-基本設定</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">
    <script src="js/script.js"></script>
</head>

<body>
 <div class="image-container">
        <img src="images/main.jpeg" alt="ペンを持ったロボット" class="logo2">
    </div>
    <header>
        <h1>基本設定</h1>
    </header>
    <main>
        <section id="basic-settings">
            <form>
                <fieldset>
                    <legend>担当の種類作成</legend>
                    <label for="roles">担当の種類を登録:</label>
                    <select id="roles" name="roles[]" multiple>
                        <option value="floor">フロア</option>
                        <option value="bath">入浴</option>
                        <option value="record">記録</option>
                        <option value="transport">送迎</option>
                        <option value="free">フリー</option>
                        <option value="nursing">看護</option>
                        <option value="officework">事務</option>
                        <option value="free&transport">フリ/送</option>
                        <option value="free&officework">フリ/事</option>
                        <option value="cook">厨房</option>
                    </select>
                    <button type="button">追加</button>
                </fieldset>

                <fieldset>
                    <legend>シフトの種類作成</legend>
                    <label for="shift-types">シフトの種類を登録:</label>
                    <select id="shift-types" name="shift-types[]" multiple>
                        <option value="oneday">通常フル</option>
                        <option value="am">午前勤</option>
                        <option value="pm">午後勤</option>
                    </select>
                    <button type="button">追加</button>
                </fieldset>

                <fieldset>
                    <legend>スタッフ登録</legend>
                    <label for="staff-name">スタッフ名:</label>
                    <input type="text" id="staff-name" name="staff-name" placeholder="スタッフ名を入力">
                    <button type="button">登録</button>
                </fieldset>

                <fieldset>
                    <legend>スケジュール基本設定</legend>
                    <label for="closed-days">休業日 曜日設定:</label>
                    <select name="dow">
                        <option value="mon">月曜日</option>
                        <option value="tue">火曜日</option>
                        <option value="wed">水曜日</option>
                        <option value="thu">木曜日</option>
                        <option value="fri">金曜日</option>
                        <option value="sat">土曜日</option>
                        <option value="sun">日曜日</option>
                    </select>
                    <button type="button" id="add-close">追加</button>

                    <label for="basic-schedule">必要スタッフ数設定:</label>
                    <div>
                        <label for="staff-type">担当の種類を選択:</label>
                        <select id="staff-type" name="staff-type">
                            <option value="floor">フロア</option>
                            <option value="bath">入浴</option>
                            <option value="record">記録</option>
                            <option value="transport">送迎</option>
                            <option value="free">フリー</option>
                            <option value="nursing">看護</option>
                            <option value="officework">事務</option>
                            <option value="free&transport">フリ/送</option>
                            <option value="free&officework">フリ/事</option>
                            <option value="cook">厨房</option>
                        </select>

                        <label for="staff-number">必要人数を選択:</label>
                        <select id="staff-number" name="staff-number">
                            <option value="1">1人</option>
                            <option value="2">2人</option>
                            <option value="3">3人</option>
                            <option value="4">4人</option>
                            <option value="5">5人</option>
                        </select>
                        <button type="button" id="add-staff">追加</button>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>シフト作成時のルール設定</legend>
                    <label class="toggle-switch">
                        <input type="checkbox" checked>
                        <span class="slider"></span>
                    </label>
                    <label for="workdays">連続勤務日数上限は以下とする</label>
                    <textarea id="rules1" name="rules1" rows="2" placeholder="日数"></textarea><a>日</a></br>
                    <label class="toggle-switch">
                        <input type="checkbox" checked>
                        <span class="slider"></span>
                    </label>
                    <label for="same-type">同じ担当業務の連続割当上限日数</label>
                    <textarea id="rules2" name="rules2" rows="2" placeholder="日数"></textarea><a>日</a></br>

                <button type="submit" class="record">設定を保存</button>
            </form>
        </section>
    </main>

    <div class="return-main">
        <button onclick="location.href='index.jsp'" class="return">TOPに戻る</button>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>