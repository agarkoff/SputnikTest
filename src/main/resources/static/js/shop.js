$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/product/list"
    }).then(function (products) {
        $.each(products, function () {
            var form = $('#template').clone();
            form.attr('id', this.sku);
            form.attr('style', '');
            initHandlers(form);
            fillForm(form, this);
            form.appendTo('#products');
        });
        addBlank();
    });
});

function initHandlers(form) {
    form.find("button[name=delete]").click(function () {
        del(form);
    });
    form.find("button[name=save]").click(function () {
        save(form);
    });
    form.find("button[name=move]").click(function () {
        move(form);
    });
}

function fillForm(form, product) {
    form.find("input[name=sku]").val(product.sku);
    form.find("input[name=price]").val(product.price);
    form.find("select[name=category]").val(product.category);
    form.find("select[name=size]").val(product.size);
    form.find("select[name=color]").val(product.color);
    form.find("input[name=description]").val(product.description);
    form.find("select[name=exists]").val(product.exists);
    form.attr('id', product.sku);
}

function del(form) {
    var o = form.serializeToObject();
    $.ajax({
        url: "http://localhost:8080/api/product/delete/" + o.sku,
        type: "POST",
        success: function () {
            form.remove();
        }
    });
}

function save(form) {
    var json = JSON.stringify(form.serializeToObject());
    $.ajax({
        url: "http://localhost:8080/api/product/save",
        type: "POST",
        data: json,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (product) {
            fillForm(form, product);
            if (form.find("button[name=save]").text() === "Добавить") {
                addBlank();
            }
        }
    });
}

function move(form) {
    var o = form.serializeToObject();
    var exists = o.exists === "WAREHOUSE" ? "SHOP" : "WAREHOUSE";
    $.ajax({
        url: "http://localhost:8080/api/product/move/" + o.sku + "/" + exists,
        type: "POST",
        success: function (product) {
            fillForm(form, product);
        }
    });
}

function addBlank() {
    var form = $('#template').clone();
    form.attr('id', '');
    form.attr('style', '');
    form.find("button[name=save]").text("Добавить");
    initHandlers(form);
    form.appendTo('#products');
}
