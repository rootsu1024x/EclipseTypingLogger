EclipseTypingLogger
===================

Eclipseを起動中に自分がどれだけの数タイプしたかを60秒ごとに記録し、CSVにしてくれます

## これはなに？

Eclipseプラグインです。

pluginsフォルダに放り込んで、Eclipseを起動し、ウィンドウ→ビューの表示からStrokeLogger Viewを開くとロギング有効・無効ボタンのみを持つビューが開きます。

同時に、Eclipseのホームディレクトリにlog.txtの名前でログファイルが作成されます。同名のファイルがある場合中身が混合してしまうので移動してください。

ロギングを有効にすると、log.txtに60秒ごとに、キータイプ数をcsvのような形式で記録してくれます。

    開始時間(UNIX秒),終了時間(UNIX秒),タイプ数

の形式です。

なお、タイプ数が-1になっている箇所がロギングを有効にした瞬間です。

## ライセンス

コードの一部に

sandipchitaleseclipseplugins - Sandip Chitale's Eclipse Plug-ins - Google Project Hosting - https://code.google.com/p/sandipchitaleseclipseplugins/#Key_Strokes

のコードが含まれています。

そのコードが修正BSDライセンスなので、本プログラムも修正BSDライセンスとします。

## なんでこんなものを…るーつにゃんさん…酸素欠乏症にかかって…

自分がどのくらいコードを書く活動をしているか、つまりコーディングアクティビティを計りたかったから…です…。

いずれグラフ化とかWeb化とかできるといいな！！
