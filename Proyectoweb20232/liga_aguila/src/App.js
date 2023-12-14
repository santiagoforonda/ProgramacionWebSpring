import './App.css';
import RouterManager from './RouterManager';

import React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';

import Typography from '@mui/material/Typography';

import Container from '@mui/material/Container';

import Button from '@mui/material/Button';
import Icon from '@mdi/react';

import { mdiGlassMug } from '@mdi/js';

function App() {

  const pages = [{text:"Home",path:"/"},  {text:"Lista de resultados",path:"/listResults"}, {text:"Registrar partido",path:"/register_match"}, {text:"Registrar equipo",path:"/register_team"}  ];


  return (
    <>
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters >
          <Icon path={mdiGlassMug} size={3} />
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              color: '#eccc68',
              textDecoration: 'none',
            }}
          >
            LIGA AGUILA
          </Typography>

          <Box sx={{ flexGrow: 1, display:{ xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (<Button sx={{ my: 2 , color:'white', display:'block'}}  component="a" href={page.path} > 
              {page.text}
            </Button>)
              
            )}
          </Box>
          <img className='logo' src="https://polideportes.poligran.edu.co/wp-content/uploads/2019/04/Liga_Aguila.png" alt="hola"></img>
          
          
    
        </Toolbar>
      </Container>
    </AppBar> 
    <div className='fondo'></div>
      
    
    <RouterManager></RouterManager>
    </>
      
    
  );
}

export default App;
