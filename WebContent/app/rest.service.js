angular.module('ien').service('$rest',['$resource',function($resource){
    return {

        livro: function(){

            return $resource('/PortalIEN/rs/livro/:codigo', {
                codigo: '@codigo'
            },{
                update: {
                    method: 'PUT'
                }
            });

        },

        autor: function(){

            return $resource('/PortalIEN/rs/autor/:codigo', {
                codigo: '@codigo'
            },{
                update: {
                    method: 'PUT'
                }
            });

        },

        categoria: function(){

            return $resource('/PortalIEN/rs/categoria/:codigo', {
                codigo: '@codigo'
            },{
                update: {
                    method: 'PUT'
                }
            });

        }
    };
}]);
