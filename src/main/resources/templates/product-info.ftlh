<!DOCTYPE html>
<html>
<head>
<title>BUYSELL</title>
</head>
<body>
<h1>BUY SELL</h1><hr>
<h4>Подробная информация о товаре</h4>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.descriptions}<br>
<b>Цена товара: </b>${product.price}<br>
<b>Город: </b>${product.city}<br>
<b>Автор: </b>${product.author}<br>
<hr>
<h3>Удалить товар</h3>
<form action="/product/delete/${product.id}>" metod="post">
<input type="submit" value="Удалить товар"/>
</from>
</body>
</html>
