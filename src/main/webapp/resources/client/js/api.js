function loadCart(){
    $.ajax({
        url: "/api/cart",
        dataType: "json",
        method: "GET",
        headers:{
            "Content-Type": "application/json"
        },
        success: (rs) => {
            $('#count-cart').html(rs.length);
        },
        error: (rs) => {
            if(rs.status == 401){
                $('#count-cart').html(0);
            }
        }
    });
}
loadCart();
$('.add-cart').off('click').on('click', function (e) {
    e.preventDefault();
    var btn = $(this);
    var id = btn.data('id');
    var quantity = btn.data('quantity');
    var data = {
        sanpham: id,
        soluong: quantity
    }
    $.ajax({
        url: "/api/cart",
        dataType: "json",
        method: "POST",
        data: JSON.stringify(data),
        headers:{
            "Content-Type": "application/json"
        },
        success: (rs) => {
            alert('Thêm vào giỏ hàng thành công!');
            loadCart();
        },
        error: (rs) => {
            if(rs.status == 401){
                alert('Bạn cần đăng nhập trước!');
                document.location.href = "/login";
            }else if(rs.status == 200){
                alert('Thêm vào giỏ hàng thành công!');
                loadCart();
            }else {
                alert('Có lỗi xảy ra, thêm giỏ hàng thất bại!');
            }
        }
    });
});
$('.del-cart').off('click').on('click', function (e) {
    e.preventDefault();
    if (window.confirm('Bạn có chắc chắn muốn xóa giỏ hàng hay không?')) {
        var btn = $(this);
        var id = btn.data('id');
        var data = {
            sanpham: id
        }
        $.ajax({
            url: "/api/cart",
            dataType: "json",
            method: "DELETE",
            data: JSON.stringify(data),
            headers:{
                "Content-Type": "application/json"
            },
            success: (rs) => {
                alert('Xóa giỏ hàng thành công!');
                document.location.href = "/cart";
            },
            error: (rs) => {
                if(rs.status == 401){
                    alert('Bạn cần đăng nhập trước!');
                    document.location.href = "/login";
                }else if(rs.status == 200){
                    alert('Xóa giỏ hàng thành công!');
                    document.location.href = "/cart";
                }else {
                    alert('Có lỗi xảy ra, xóa giỏ hàng thất bại!');
                }
            }
        });
    }
});
$('.update-cart').off('click').on('click', function (e) {
    e.preventDefault();
    var btn = $(this);
    var id = btn.data('id');
    var quantity = btn.data('quantity');
    var data = {
        sanpham: id,
        soluong: quantity
    }
    $.ajax({
        url: "/api/cart",
        dataType: "json",
        method: "PUT",
        data: JSON.stringify(data),
        headers:{
            "Content-Type": "application/json"
        },
        success: (rs) => {
            alert('Cập nhập giỏ hàng thành công!');
            document.location.href = "/cart";
        },
        error: (rs) => {
            if(rs.status == 401){
                alert('Bạn cần đăng nhập trước!');
                document.location.href = "/login";
            }else if(rs.status == 200){
                alert('Cập nhập giỏ hàng thành công!');
                document.location.href = "/cart";
            }else {
                alert('Có lỗi xảy ra, cập nhập giỏ hàng thất bại!');
            }
        }
    });
});
$('.payment').off('click').on('click', function (e) {
    e.preventDefault();
    $.ajax({
        url: "/api/hoadon/createQR",
        dataType: "json",
        method: "GET",
        success: (rs) => {
            $('#qr').attr('src', rs.data.qrDataURL);
            $('#myModal').modal("show");
        },
        error: (rs) => {
            if(rs.status == 401){
                alert('Bạn cần đăng nhập trước!');
                document.location.href = "/login";
            }else if(rs.status == 200){
                $('#qr').attr('src', rs.data.qrDataURL);
                $('#myModal').modal("show");
            }else {
                alert('Có lỗi xảy ra, thanh toán thất bại!');
            }
        }
    });
});
function payment(){
    $.ajax({
        url: "/api/hoadon",
        dataType: "json",
        method: "POST",
        success: (rs) => {
            alert("Hóa đơn của bạn đã được chuyển đến người quản lý");
            document.location.href = "/cart";
        },
        error: (rs) => {
            if(rs.status == 401){
                alert('Bạn cần đăng nhập trước!');
                document.location.href = "/login";
            }else if(rs.status == 200){
                alert("Hóa đơn của bạn đã được chuyển đến người quản lý");
                document.location.href = "/cart";
            }else {
                alert('Có lỗi xảy ra, thanh toán thất bại!');
            }
        }
    });
}