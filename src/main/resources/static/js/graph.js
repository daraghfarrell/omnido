angular.module('graph', [])
    .controller('home', function($http) {
        var self = this;
        $http.get('/anytodo').then(function(response) {
            self.greeting = response.data;
        })
    });
