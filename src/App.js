import React from 'react';

import {
    Box, Button, Container, Grid, makeStyles, Typography, Slider, TextField
} from '@material-ui/core';
import './App.css';


const useStyles = makeStyles(theme => ({
  root: {
    width: 300,
  },
  margin: {
    height: theme.spacing(3),
  },
}));



function valuetext(value) {
  return `${value}°C`;
}


function DiscreteSlider() {
  const classes = useStyles();
  const [values, setValues] = React.useState({
    n: 30,
  });

  const handleChange = name => event => {
    setValues({ ...values, [name]: event.target.value });
  };


  return (
    <div className={classes.root}>
      <Typography id="discrete-slider" gutterBottom>
        n degeri
      </Typography>
      <Slider
        defaultValue={20}
        getAriaValueText={valuetext}
        aria-labelledby="discrete-slider"
        valueLabelDisplay="auto"
        step={1}
        marks
        min={5}
        max={100}
      />

      <TextField
        id="standard-number"
        label="Number"
        value={values.age}
        onChange={handleChange('n')}
        type="number"
        min={2}
        max={100}
        className={classes.textField}
        InputLabelProps={{
          shrink: true,
        }}
        margin="normal"
      />



    </div>
  );
}


function App() {
  return (
    <Box m={10}>
      <Container className="container" maxWidth="md">


        <Grid container >
          <Grid item   >

            <DiscreteSlider />

            <Button variant="contained" color="primary">
              Grafik Oluştur
            </Button>
            <Container className="containergraphmatrix">
              martrix_alanı
            </Container>
            <Container className="containergraphlist" >
              list_alanı
            </Container>
          </Grid>

          
        </Grid>
        <Container className="containergraph" maxWidth="md">
          graphalanı
        </Container>


      </Container>
    </Box>
    
  );
}

export default App;
