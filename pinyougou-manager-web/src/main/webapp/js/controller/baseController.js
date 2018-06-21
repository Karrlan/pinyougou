/* 基本前端控制器*/
app.controller('baseController',function ($scope) {
    //定义分页组件需要的组件信息
    $scope.paginationInfo = {
        currentPage : 1, // 当前页码
        totalItems : 0, // 总记录数
        itemsPerPage : 10, // 每页显示的记录数
        perPageOptions : [10,20,30], // 页码下拉列表框中的option
        onChange : function(){ // 页码改变事件
            // 查询数据
            $scope.reload();
        }


    };

    //重新查询数据
    $scope.reload = function(){
        $scope.search ($scope.paginationInfo.currentPage,$scope.paginationInfo.itemsPerPage)
    }

    //定义数组接受删除ID
    $scope.ids = [];

    //根据ID删除品牌名称
    $scope.updateSelection = function ($event,id) {
        if($event.target.checked){
            $scope.ids.push(id);
        }else {
            var idx = $scope.ids.indexOf(id);

            $scope.ids.splice(idx,1);
        }
    };

    
})