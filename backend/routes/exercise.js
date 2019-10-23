const router = require('express').Router();
let Exercise = require('../model/graph');

router.route('/').get((req, res) => {
  Exercise.find()
    .then(exercise => res.json(exercise))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/add').post((req, res) => {
  const slidernumber = Number(req.slidernumber);

  const n_degeri = Number(req.body.duration);
  
  const newExercise = new Exercise({
    slidernumber,
    n_degeri
  });

  newExercise.save()
  .then(() => res.json('Exercise added!'))
  .catch(err => res.status(400).json('Error: ' + err));
});

module.exports = router;