/* 定义品牌控制层 */

app.controller('brandController',function ($scope,$controller,baseService) {

    //指定继承controller
    $controller('baseController',{$scope:$scope});

    //读取数据绑定到表格中
    $scope.findAll = function () {
        //发送异步请求获取数据
        baseService.sendGet('/brand/findAll')
            .then(function (response) {
                $scope.dataList = response.data;
            });
    };


    //定义JSON对象的封装条件
    $scope.searchEntity = {};

    //分页查询数据
    $scope.search = function (page,rows) {
        baseService.findByPage( '/brand/findByPage',page , rows,$scope.searchEntity)
            .then(function (response) {
            //获取响应数据
            $scope.dataList = response.data.rows;
            //设置总记录数
            $scope.paginationInfo.totalItems = response.data.total;
        })
    };
    //新建品牌

    $scope.saveOrUpdate = function () {
        var url ='save';
        if($scope.entity.id){
            url = 'update';
        }
        baseService.sendPost('/brand/'+url,$scope.entity)
            .then(function (value) {
                if(value.data){
                    //重新加载
                    $scope.reload();
                }else{
                    alert("添加失败");
                }
            });
    };
    //修改时显示数据
    $scope.show = function (entity) {
        $scope.entity = entity;
    };



    //批量删除品牌
    $scope.deleteBrand = function () {
        if($scope.ids.length > 0){
            baseService.sendGet('/brand/delete?ids='+ $scope.ids)
                .then(function (value) {
                    if(value.data){
                        //删除成功
                        $scope.reload();
                        alert("删除成功");
                    }
                })
        }else{
            alert("请选择你要删除的品牌");
        }
    };


})