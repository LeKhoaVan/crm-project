$(function(){
    $.ajax({
        url : "http://localhost:8080/crm_project/api/role",
        method: "GET"
    }).done(function(result){
        $("#example tbody").empty()
        $.each(result, function(index,value){

            var row = `<tr>
                <td>${value.id}</td>
                <td>${value.name}</td>
                <td>${value.description}</td>
                <td>
                <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                <a href="#" class="btn btn-sm btn-danger btn-xoa" role-id="${value.id}">Xóa</a>
                </td>
            </tr>`

            $("#example tbody").append(row)
        })
        
    })

    $('body').on('click','.btn-xoa',function(){
        // Lấy thuộc tính role-id từ button được click
        var roleId = $(this).attr('role-id')
        var This = $(this)
        // $(this).closest('tr').remove()
        // location.reload()

        $.ajax({
            url: `http://localhost:8080/crm_project/api/role?id=${roleId}`, //Link lấy danh sách role
            method: "DELETE", //Phương thức tương ứng với link
            // data: {
            //     key: value
            // },
            // dataType: "application/json"
        }).done(function(result){
            // Lấy thành công và trả ra kết quả
            if(result.isSucces == true){
                console.log("Xoá thành công !")
                $.toast({
                    heading: 'Xóa thành công',
                    text: '',
                    position: 'top-right',
                    loaderBg:'#ff6849',
                    icon: 'success',
                    hideAfter: 3500, 
                    stack: 6
                  });
                $(This).closest('tr').remove()
            }else{
                console.log("Xoá thất bại !")
            }
        })
        
    })
    $('#add-role').click(function(e){
        e.preventDefault()  // chặn lại không thực thì form
        var role = $('#roleName').val() // lấy giá trị của form role-add.html
        var dataDescription = $("#description").val()
        $.ajax({
            url : "http://localhost:8080/crm_project/api/role",
            method : "POST",
            data : {
                roleName : role,
                description : dataDescription
            },
        }).done(function(result){
            if(result.isSucces == true){
                console.log("Thêm thành công !")
                $.toast({
                    heading: 'Thêm thành công',
                    text: '',
                    position: 'top-right',
                    loaderBg:'#ff6849',
                    icon: 'success',
                    hideAfter: 3500, 
                    stack: 6
                  })
                  $('#roleName').val("") 
                  $("#description").val("") 
            } else {
                console.log("thêm thất bại !")
                $.toast({
                    heading: 'thêm thất bại',
                    text: '',
                    position: 'top-right',
                    loaderBg:'#ff6849',
                    icon: 'error',
                    hideAfter: 3500, 
                    stack: 6
                  });
            }
        })
    })

})