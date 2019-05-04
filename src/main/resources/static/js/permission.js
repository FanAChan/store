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
                content: "../permission/edit.html",
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
        , url: '/store/permission/page'
        , cols: [[ //标题栏
            {type: 'checkbox', fixed: 'left'}
            , {type: 'numbers', title: '序号', align: 'center', width: 80, fixed: 'left'}
            , {field: 'id', title: 'ID', sort: true, fixed: 'left'}
            , {field: 'name', title: '名称'}
            , {field: 'url', title: '路径'}
            , {field: 'description', title: '描述'}
            , {field: 'menu', title: '所属菜单'}
            , {field: 'seq', title: '排序'}
            , {field: 'limited', title: '受限'}
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