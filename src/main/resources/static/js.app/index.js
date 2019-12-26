const index = {
    init: function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: () => {
        let data = {
            title: $("#title").val(),
            author: $("#author").val(),
            content: $("#content").val()
        };
        
        $.ajax({
            url: '/api/v1/posts',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(() => {
            alert("글이 등록되었습니다.");
            window.location.href = '/';
        }).fail((err) => {
            alert(JSON.stringify(err))
        });

    }
};

index.init();