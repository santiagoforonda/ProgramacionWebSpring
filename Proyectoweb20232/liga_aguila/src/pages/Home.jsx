import { Grid,Box} from '@mui/material';
import * as React from 'react';
import BasicTable from '../componentesUI/BasicTable';
import MediaCard from '../componentesUI/MediaCard';
import Chica from '../components/Chica';
import Estadio from '../components/Estadio';

import "../estilosComponentes/Home.css";

function Home(){

    return(
        
        <>
        <Box className="contenedor-principal">
        <Grid container spacing={2} >
            <Grid item xs={5}>
            <h3>Ultimas noticias</h3>
            <hr className='linea'></hr>
            <div className='contenido-noticias'>
            <MediaCard imagen="messi" titulo="Messi se une al union magdalena" descripcion="Despues de un largo proceso de compra el nuevo jugador del equipo bananero debutara este 18 de abril en el estadio Eduardo Santos de santa marta"></MediaCard>
            <MediaCard  imagen="junior" titulo="Junior posible campeon" descripcion="Segun los resultados de los ultimos partidos jugados por el equipo tiburon, el junior se ha convertido en el favoritdo del publico y de los expertos, parece que esta sera su doceava(12) copa"></MediaCard>
            <MediaCard imagen="rolos" titulo="Los rolos del nacional" descripcion="Los ultimos reportes indican que los jugadores del equipo nacional estaban consumiendo sustancias ilicitas para asi poder aumentar el rendimiento en sus partidos, el director testifico y afirma que no estaba enterado de la situacion"></MediaCard>
            <MediaCard imagen ="union" titulo="El Union Magdalena sube a la A" descripcion="Al fin despues de tantos esfuerzos el equipo samario ha logrado subir de liga, esto debe ser gracias a la fuerte emocion que tienen los jugados por la compra de Leonel Messi por parte del equipo tecnico del equpo, se espera una gran cantidad de turistas por la llegada del jugador"></MediaCard>
            </div>
            </Grid>


            <Grid item xs={7}>
            <h3>Tabla de puntos</h3>
            <hr className='linea-puntos'></hr>
            <div className='contenedor-tablaDePuntuacion'>
                <BasicTable></BasicTable>
            </div>
            </Grid>


            <Grid item xs={6}>
            <h3>Las mejores chicas aguila</h3>
            <hr className='linea-chicas'></hr>
            <div className='contenedor-chicas'>
                <Chica nombre="Linda Caicedo" descripcion="Linda Lizeth Caicedo Alegría es una futbolista colombiana que juega como delantera en el Real Madrid C. F. de la Primera División de España. En 2022 fue reconocida como la segunda mejor jugadora del mundo por los Globe Soccer Awards." imagen="linda_caicedo"></Chica>
                <Chica nombre ="Daniela Arias" descripcion="Daniela Arias es una futbolista colombiana. Juega en la posición de defensa de la selección nacional de fútbol colombiano y en América de Cali" imagen="daniela_arias"></Chica>
            </div>
            </Grid>

            <Grid item xs={6}>
            <h3>Estadios</h3>
            <hr className='linea-estadios'></hr>
            <div className='contenedor-estadios'>
                <Estadio nombre="Metropolitano" imagen="metropolitano"></Estadio>
                <Estadio nombre="Sierra" imagen="sierra"></Estadio>
                <Estadio nombre="Campin" imagen="campin"></Estadio>
                <Estadio nombre="Atanasio" imagen="atanasio"></Estadio>
            </div>
            </Grid>


        </Grid>
        </Box>
        </>
    );


}

export default Home;