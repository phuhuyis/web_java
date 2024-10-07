$('.del-nhanhieu').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa nhãn hiệu này hay không?")) {
        $.ajax({
            url: "/api/admin/nhanhieu/" + btn.data('id'),
            dataType: "json",
            method: "DELETE",
            success: (rs) => {
                alert("Xóa nhãn hiệu thành công!");
                document.location.href = "/admin/nhanhieu";
            },
            error: (rs) => {
                alert('Nhãn hiệu không tồn tại!');
            }
        });
    }
});
$('.del-loaisanpham').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa loại sản phẩm này hay không?")) {
        $.ajax({
            url: "/api/admin/loaisanpham/" + btn.data('id'),
            dataType: "json",
            method: "DELETE",
            success: (rs) => {
                alert("Xóa loại sản phẩm thành công!");
                document.location.href = "/admin/loaisanpham";
            },
            error: (rs) => {
                alert('Loại sản phẩm không tồn tại!');
            }
        });
    }
});
$('.del-khachhang').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa khách hàng này hay không?")) {
        $.ajax({
            url: "/api/admin/khachhang/" + btn.data('id'),
            dataType: "json",
            method: "DELETE",
            success: (rs) => {
                alert("Xóa khách hàng thành công!");
                document.location.href = "/admin/khachhang";
            },
            error: (rs) => {
                alert('Khách hàng không tồn tại!');
            }
        });
    }
});
$('.del-sanpham').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này hay không?")) {
        $.ajax({
            url: "/api/admin/sanpham/" + btn.data('id'),
            dataType: "json",
            method: "DELETE",
            success: (rs) => {
                alert("Xóa sản phẩm thành công!");
                document.location.href = "/admin/sanpham";
            },
            error: (rs) => {
                alert('Sản phẩm không tồn tại!');
            }
        });
    }
});
$('.del-slide').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa slide này hay không?")) {
        $.ajax({
            url: "/api/admin/slide/" + btn.data('id'),
            dataType: "json",
            method: "DELETE",
            success: (rs) => {
                alert("Xóa slide thành công!");
                document.location.href = "/admin/slide";
            },
            error: (rs) => {
                alert('Slide không tồn tại!');
            }
        });
    }
});
$('.del-lienhe').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa liên hệ này hay không?")) {
        $.ajax({
            url: "/api/admin/lienhe/" + btn.data('id'),
            dataType: "json",
            method: "DELETE",
            success: (rs) => {
                alert("Xóa liên hệ thành công!");
                document.location.href = "/admin/lienhe";
            },
            error: (rs) => {
                alert('Liên hệ không tồn tại!');
            }
        });
    }
});
$('.success-lienhe').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    $.ajax({
        url: "/api/admin/lienhe/success/" + btn.data('id'),
        dataType: "json",
        method: "PUT",
        success: (rs) => {
            document.location.href = "/admin/lienhe";
        },
        error: (rs) => {
            alert('Liên hệ không tồn tại!');
        }
    });
});
$('.progress-lienhe').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    $.ajax({
        url: "/api/admin/lienhe/progress/" + btn.data('id'),
        dataType: "json",
        method: "PUT",
        success: (rs) => {
            document.location.href = "/admin/lienhe";
        },
        error: (rs) => {
            alert('Liên hệ không tồn tại!');
        }
    });
});
$('.paid-hoadon').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    $.ajax({
        url: "/api/admin/hoadon/" + btn.data('id'),
        dataType: "json",
        method: "PUT",
        success: (rs) => {
            document.location.href = "/admin/hoadon";
        },
        error: (rs) => {
            alert('Hóa đơn không tồn tại!');
        }
    });
});
$('.unpaid-hoadon').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    $.ajax({
        url: "/api/admin/hoadon/" + btn.data('id'),
        dataType: "json",
        method: "POST",
        success: (rs) => {
            document.location.href = "/admin/hoadon";
        },
        error: (rs) => {
            alert('Hóa đơn không tồn tại!');
        }
    });
});
$('.del-hoadon').off('click').on('click', function(e){
    e.preventDefault();
    var btn = $(this);
    if (confirm("Bạn có chắc chắn muốn xóa hóa đơn này hay không?")) {
        $.ajax({
            url: "/api/admin/hoadon/" + btn.data('id'),
            dataType: "json",
            method: "DELETE",
            success: (rs) => {
                alert("Xóa hóa đơn thành công!");
                document.location.href = "/admin/hoadon";
            },
            error: (rs) => {
                alert('Hóa đơn không tồn tại!');
            }
        });
    }
});