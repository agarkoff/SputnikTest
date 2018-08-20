<%@ page import="ru.misterparser.shop.domain.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Shop</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-utils.js"></script>
    <script src="${pageContext.request.contextPath}/js/shop.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop.css"/>
</head>

<body>
<div id="products">
    <form id="template" style="display:none;" class="product">
        <table>
            <tbody>
            <tr>
                <td>Артикул</td>
                <td>
                    <input name="sku">
                </td>
            </tr>
            <tr>
                <td>Цена</td>
                <td>
                    <input name="price">
                </td>
            </tr>
            <tr>
                <td>Категория</td>
                <td>
                    <c:set var="categories" value="<%=Product.Category.values()%>"/>
                    <select name="category">
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.name()}">${category.toString()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Размер</td>
                <td>
                    <c:set var="sizes" value="<%=Product.Size.values()%>"/>
                    <select name="size">
                        <c:forEach var="size" items="${sizes}">
                            <option value="${size.name()}">${size.toString()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Цвет</td>
                <td>
                    <c:set var="colors" value="<%=Product.Color.values()%>"/>
                    <select name="color">
                        <c:forEach var="color" items="${colors}">
                            <option value="${color.name()}">${color.toString()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Описание</td>
                <td>
                    <input name="description">
                </td>
            </tr>
            <tr>
                <td>Наличие</td>
                <td>
                    <c:set var="exists" value="<%=Product.Exists.values()%>"/>
                    <select name="exists">
                        <c:forEach var="exist" items="${exists}">
                            <option value="${exist.name()}">${exist.toString()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <button name="delete" onclick="return false;">Удалить</button>
                </td>
                <td>
                    <button name="save" onclick="return false;">Сохранить</button>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button name="move" onclick="return false;">Переместить</button></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
