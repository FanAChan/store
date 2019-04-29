layui.use(['element', 'table'], function () {
    var element = layui.element;
    var table = layui.table;
    //监听表格复选框选择
    table.on('checkbox(demo)', function (obj) {
        console.log(obj)
    });

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            detail(data.id);
            // layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.alert('编辑行：<br>' + JSON.stringify(data))
        }
    });

    table.render({
        elem: '#demo'
        , url: '/store/unit/page'
        , cols: [[ //标题栏
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: 'ID', width: 250, sort: true, fixed: 'left'}
            , {field: 'name', title: '名称', width: 250}
            , {field: 'description', title: '描述', minWidth: 250}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
        , toolbar: 'default'
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