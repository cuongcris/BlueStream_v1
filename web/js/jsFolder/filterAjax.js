function filter(page) {
    const nameFilter = document.getElementById("nameFilter").value;
    const viewFilter = document.getElementById("viewFilter").value;
    const search = document.getElementById('search-bar');
    $.ajax({
        url: "/BlueFashion/AllMovie",
        data: {
            page:page,
            nameFilter: nameFilter,
            viewFilter: viewFilter,
            txtSearch: search.value
        },
        traditional: true,
        type: "post",
        success: function (response) {
            const productContainer = document.querySelector(".product-container-list");
            productContainer.innerHTML = response;
            $('.set-bg').each(function () {
                var bg = $(this).data('setbg');
                $(this).css('background-image', 'url(' + bg + ')');
            });
        },
        error: function (xhr) {
            console.log("ERROR Ajax");
        }
    });
}
document.getElementById('search-bar').addEventListener('input', () => filter(1));
