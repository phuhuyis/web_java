var host = "tourdulich";

$('.del-category').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa loại tour hay không?")) {
        alert("Xóa loại tour thành công");
        document.location.href = "/" + host + "/admin/category/delete?id=" + btn.data('id');
    }
})
$('.del-customer').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa khách hàng hay không?")) {
        alert("Xóa khách hàng thành công");
        document.location.href = "/" + host + "/admin/customer/delete?id=" + btn.data('id');
    }
})
$('.del-product').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa tour du lịch hay không?")) {
        alert("Xóa tour du lịch thành công");
        document.location.href = "/" + host + "/admin/product/delete?id=" + btn.data('id');
    }
})