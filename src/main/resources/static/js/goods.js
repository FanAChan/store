layui.use(['element', 'table', 'jquery', 'tree', 'form', 'treeSelect'], function () {
    var element = layui.element;
    var table = layui.table;
    var $ = layui.jquery;
    var form = layui.form;
    var treeSelect = layui.treeSelect;
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
                content: "../goods/edit.html",
                btn: ["确定"],
                btnAlign: "c",
                yes: function (index, layero) {
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                },
                success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    body.find('#id').val(local_data.id);
                    body.find('#name').val(local_data.name);
                    body.find('#description').val(local_data.description);
                    body.find('input').attr('disabled', 'disabled');
                    body.find('input').addClass('layui-disabled');
                    body.find('textarea').attr('disabled', 'disabled');
                    body.find('textarea').addClass('layui-disabled');
                },
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        } else if (obj.event === 'del') {
            //删除事件
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    url: "/store/goods/delete",
                    type: "post",
                    data: {
                        "id": local_data.id
                    },
                    success: function (data) {
                        if (data.success) {
                            layer.close(index);
                            obj.del();
                            layer.msg(data.message);
                            // $(".layui-laypage-btn").click();
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
            })
        } else if (obj.event === 'edit') {
            //编辑事件

            layer.open({
                type: 2,
                title: "编辑",
                closeBtn: 1,
                area: ['650px', '400px'],
                shadeClose: true,
                skin: "layui-layer-molv",
                content: "../goods/edit.html",
                btn: ["确定", "取消"],
                btnAlign: "c",
                btn2: function (index, layero) {
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                },
                success: function (layero, index) {
                },
                yes: function (index, layero) {
                    var body = layer.getChildFrame('body', index);
                    var new_number = body.find('#number').val();
                    var new_name = body.find('#name').val();
                    var new_typeId = body.find('#typeId').val();
                    var new_majorUnitId = body.find('#majorUnitId').val();
                    if (new_name != local_data.name || new_number != local_data.number
                        || new_typeId != local_data.typeId || new_majorUnitId != local_data.majorUnitId) {
                        $.ajax({
                            url: "/store/goods/update",
                            type: "post",
                            data: {
                                id: local_data.id,
                                number: new_number,
                                name: new_name,
                                typeId: new_typeId,
                                majorUnitId: new_majorUnitId
                            },
                            success: function (data) {
                                if (data.success) {
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
                    } else {
                        layer.msg("未进行更改");
                    }
                    layer.close(index);
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
        , url: '/store/goods/page'
        , cols: [[ //标题栏
            {type: 'checkbox', fixed: 'left'}
            , {type: 'numbers', title: '序号', align: 'center', fixed: 'left'}
            , {field: 'id', title: 'ID', fixed: 'left'}
            , {field: 'number', title: '编码', sort: true}
            , {field: 'goodsType', title: '类型'}
            , {field: 'majorUnit', title: '主单位'}
            // , {field: 'auxiliaryUnit', title: '辅类型', minWidth: 250}
            // , {field: 'inPrice', title: '进价', minWidth: 250}
            // , {field: 'outPrice', title: '售价', minWidth: 250}
            , {field: 'manufacturer', title: '生产厂商'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
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

    //新增事件
    $(document).on('click', '#add', function () {
        layer.open({
            type: 2,
            title: "新增",
            closeBtn: 1,
            area: ['650px', '400px'],
            shadeClose: true,
            skin: "layui-layer-molv",
            content: "../goods/add.html",
            btn: ["确定", "取消"],
            btnAlign: "c",
            yes: function (index, layero) {
                var body = layer.getChildFrame('body', index);
                var number = body.find('#number').val();
                var name = body.find('#name').val();
                var typeId = body.find('#typeId').val();
                var majorUnitId = body.find('#majorUnitId').val();
                $.ajax({
                    url: "/store/goods/add",
                    type: "post",
                    data: {
                        number: number,
                        name: name,
                        typeId: typeId,
                        majorUnitId: majorUnitId
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
            success: function (layero, index) {

            },
            cancel: function (index, layero) {
                layer.close(index)
            }
        });
    });

});