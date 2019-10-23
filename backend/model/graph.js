const mongoose = require('mongoose');


const GSchema = new mongoose.Schema({
    slidernumber:{id: "discrete-slider",type: Number,required:true},
    n_degeri:{id:"standard-number",type:Number,required:true}
});

const Graph=mongoose.model('Graph',GSchema);

module.export=Graph;