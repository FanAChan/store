layui.use(['element', 'table', 'jquery'], function () {
    var element = layui.element;
    var table = layui.table;
    var $ = layui.jquery;


    //监听表格复选框选择
    table.on('checkbox(demo)', function (obj) {
        var data = obj.data;
        layer.msg(data.id);
    });

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var local_data = obj.data;
        data = local_data;

        //查看事件
        if (obj.event === 'detail') {
            layer.open({
                type: 2,
                title: "查看",
                closeBtn: 1,
                area: ['650px', '400px'],
                shadeClose: true,
                skin: "layui-layer-molv",
                content: "../menu/edit.html",
                btn: ["确定"],
                btnAlign: "c",
                yes: function (index, layero) {
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                },
                success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    body.find('input').attr('disabled', 'disabled');
                    body.find('input').addClass('layui-disabled');
                    body.find('textarea').attr('disabled', 'disabled');
                    body.find('textarea').addClass('layui-disabled');
                },
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        }
    });

    //渲染数据表格
    table.render({
        elem: '#demo'
        , url: '/store/menu/page'
        , cols: [[ //标题栏
            {type: 'checkbox', fixed: 'left'}
            , {type: 'numbers', title: '序号', align: 'center', width: 80, fixed: 'left'}
            , {field: 'id', title: 'ID', width: 250, sort: true, fixed: 'left'}
            , {field: 'name', title: '名称', width: 250}
            , {field: 'url', title: '路径', width: 250}
            , {field: 'description', title: '描述', width: 250}
            , {field: 'image', title: '图标', width: 250}
            , {field: 'seq', title: '排序', width: 250}
            , {field: 'limited', title: '受限', width: 250}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
        , toolbar: '#toolDemo'
        , defaultToolbar: []
        , limit: 5
        , limits: [2, 5, 10]
        , loading: true
        , request: {
            pageName: 'pageNum' //页码的参数名称，默认：page
            , limitName: 'pageSize' //每页数据量的参数名，默认：limit
        },
        parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": res.status, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.data.page.total, //解析数据长度
                "data": res.data.page.list //解析数据列表
            };
        },
        page: true

    });
});

//新增事件
function add_button() {
    layer.open({
        type: 2,
        title: "新增",
        closeBtn: 1,
        area: ['400px', '300px'],
        shadeClose: true,
        skin: "layui-layer-molv",
        content: "../unit/add.html",
        btn: ["确定", "取消"],
        btnAlign: "c",
        yes: function (index, layero) {
            var body = layer.getChildFrame('body', index);
            var name = body.find('#name').val();
            var description = body.find('#description').val();
            $.ajax({
                url: "/store/unit/add",
                type: "post",
                data: {
                    name: name,
                    description: description
                },
                success: function (data) {
                    if (data.success) {
                        layer.close(index);
                        layer.msg(data.message);
                        table.reload('demo', {
                            where: {
                                data: $('#demo').val()
                            }
                        })
                    } else {
                        layer.msg(data.message);
                    }
                },
                failed: function () {
                    layer.msg("错误");
                }
            })


            layer.close(index);
        },
        btn2: function (index, layero) {
            layer.close(index);
        },
        cancel: function (index, layero) {
            layer.close(index)
        }
    });
}