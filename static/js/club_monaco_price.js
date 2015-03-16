var data = [4, 8, 15, 16, 23, 42];

var x = d3.scale.linear()
    .domain([0, d3.max(data)])
    .range([0, 420]);

var products;
d3.csv("../data/data.csv", function(data){
    data.sort(function(a, b){

        var cmp1 = d3.ascending(a.Name, b.Name);
        if (cmp1 != 0){
            return cmp1;
        }
        return d3.ascending(a.Date, b.Date);})

    products = data;

    d3.select('.chart')
      .selectAll("div")
      .data(data)
      .enter()
      .append("div")
      .style("width", function(d) {
            var priceDouble = parseFloat((d.Price).substring(1,(d.Price).length));
            return priceDouble * 0.1 + "vw"; })
      .text(function(d,i){
            return d.Name + " " + d.Date + " " + d.Price;
      })
});

var svg = d3.select('.chart')
            .append('svg')
            .attr('width', 1000)
            .attr('height', 400);

d3.csv("../data/data.csv", function(data){
    data.sort(function(a, b){

        var cmp1 = d3.ascending(a.Name, b.Name);
        if (cmp1 != 0){
            return cmp1;
        }
        return d3.ascending(a.Date, b.Date);})

    products = data;

    svg.selectAll('circle')
        .data(data)
        .enter()
        .append('circle')
        .attr('cx', function(d,i){
            console.log(i);
            return  i*30;

        })
        .attr('cy', function(d){
            var priceDouble = parseFloat((d.Price).substring(1,(d.Price).length));
                        return priceDouble * 0.1;
        })
        .attr('r', function(d){
            return 2;
        })
        .attr('fill', grey)
        .text(function(d,i){
                    return d.Name + " " + d.Date + " " + d.Price;
        });

    svg.selectAll('text')
        .data(data)
        .enter()
        .append('text')
        .text(function(d){
           return d;
           })
        .attr('x', function(d){
            return d*10;
        })
        .attr('y', function (d){
            return d;
        })


});

//svg.selectAll('circle')
//    .data(data)
//    .enter()
//    .append('circle')
//    .attr('cx', function(d){
//        return d*10;
//    })
//    .attr('cy', function(d){
//        return d*10;
//    })
//    .attr('r', function(d){
//        return 3;
//    })
//    .attr('fill', grey);
//
//svg.selectAll('text')
//    .data(data)
//    .enter()
//    .append('text')
//    .text(function(d){
//       return d;
//       })
//    .attr('x', function(d){
//        return d*10;
//    })
//    .attr('y', function (d){
//        return d;
//    })
//console.log(products);