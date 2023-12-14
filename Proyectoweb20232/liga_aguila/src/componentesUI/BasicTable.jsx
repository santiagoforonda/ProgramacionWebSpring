import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

function createData(equipo, victorias, derrotas, empates,puntos) {
  return { equipo, victorias, derrotas,empates, puntos};
}

const rows = [
  createData('Union Magdalena', 6, 6, 2, 4),
  createData('Junior', 7, 9, 3, 4),
  createData('Once caldas', 8, 1, 2, 6),
  createData('Union Petrolera', 9, 3, 6, 4),
  createData('Millonarios', 0, 1, 4, 3),
];

export default function BasicTable() {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 500 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell><strong>Equipos</strong></TableCell>
            <TableCell align="right"><strong>Victorias</strong></TableCell>
            <TableCell align="right"><strong>Derrotas</strong></TableCell>
            <TableCell align="right"><strong>Empates</strong></TableCell>
            <TableCell align="right"><strong>Puntos</strong></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row.equipo}
              </TableCell>
              
              <TableCell align="right">{row.victorias}</TableCell>
              <TableCell align="right">{row.derrotas}</TableCell>
              <TableCell align="right">{row.empates}</TableCell>
              <TableCell align="right">{row.puntos}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}