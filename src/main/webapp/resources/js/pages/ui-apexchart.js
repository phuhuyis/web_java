$.ajax({
  url: "/api/admin/report/getAmount",
  dataType: "json",
  method: "GET",
  success: (amounts) => {
    $.ajax({
      url: "/api/admin/report/getQuantity",
      dataType: "json",
      method: "GET",
      success: (quantities) => {
        var barOptions = {
          series: [
            {
              name: "Doanh thu",
              data: amounts,
            },
            {
              name: "Số lượng sản phẩm",
              data: quantities,
            },
          ],
          chart: {
            type: "bar",
            height: 500,
          },
          plotOptions: {
            bar: {
              horizontal: false,
              columnWidth: "55%",
              endingShape: "rounded",
            },
          },
          dataLabels: {
            enabled: false,
          },
          stroke: {
            show: true,
            width: 2,
            colors: ["transparent"],
          },
          xaxis: {
            categories: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
          },
          fill: {
            opacity: 1,
          },
          tooltip: {
            y: {
              formatter: function(val) {
                return val;
              },
            },
          },
        };

        var bar = new ApexCharts(document.querySelector("#bar"), barOptions);
        bar.render();
      },
      error: (rs) => {
        console.log(rs);
      }
    });
  },
  error: (rs) => {
    console.log(rs);
  }
});