const main = {
    init: function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on("click", function () {
            _this.update();
        })
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
    },
    update: () => {
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };
        let id = $("#id").val();

        $.ajax({
            url: '/api/v1/posts/' + id,
            type: 'PUT',
            dataType: 'JSON',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(data)
        }).done(()=>{
            alert("글이 수정되었습니다.");
            window.location.href = '/';
        }).catch((err) => {
            console.log(err);
            alert(JSON.stringify(err));
        });
    }
};

main.init();