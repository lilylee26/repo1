package com.mx.Curso.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Curso.Entity.Rol;
import com.mx.Curso.Entity.Usuario;
import com.mx.Curso.Repository.RolRepository;
import com.mx.Curso.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private RolRepository rolRepo;

    private static final String SOLO_LETRAS = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$";

    public Usuario guardar(Usuario usuario) {

        //CAMPOS OBLIGATORIOS
        if (usuario == null
                || usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()
                || usuario.getApp() == null || usuario.getApp().trim().isEmpty()
                || usuario.getApm() == null || usuario.getApm().trim().isEmpty()
                || usuario.getFechaNacimiento() == null
                || usuario.getRol() == null
                || usuario.getRol().getIdRol() == null) {
            throw new RuntimeException("Todos los campos obligatorios deben llenarse");
        }

        // normalizar
        String nombre = usuario.getNombre().trim();
        String app = usuario.getApp().trim();
        String apm = usuario.getApm().trim();

        // VALIDACIÓN SOLO LETRAS
        if (!nombre.matches(SOLO_LETRAS) || !app.matches(SOLO_LETRAS) || !apm.matches(SOLO_LETRAS)) {
            throw new RuntimeException("Nombre y apellidos solo pueden contener letras de la A a la Z");
        }

        // MAYOR DE 18
        LocalDate nac = usuario.getFechaNacimiento().toLocalDate();
        int edad = Period.between(nac, LocalDate.now()).getYears();
        if (edad < 18) {
            throw new RuntimeException("Solo se pueden registrar usuarios mayores a 18 años");
        }

        // DUPLICADOS
        if (repo.existsByNombreAndAppAndApm(nombre, app, apm)) {
            throw new RuntimeException("Usuario duplicado");
        }

        // VALIDAR QUE EL ROL EXISTA
        Long idRol = usuario.getRol().getIdRol();
        Rol rolBD = rolRepo.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no existe"));
        usuario.setRol(rolBD);

        //CORREO AUTOMÁTICO (y se ignora si te lo mandan)
        // formato: nombre.primerApellido@enucom.com.mx
        String correo = normalizarParaCorreo(nombre) + "." + normalizarParaCorreo(app) + "@enucom.com.mx";
        usuario.setCorreo(correo);

        //FECHA CREACIÓN HOY
        usuario.setFechaCreacion(Date.valueOf(LocalDate.now()));

        // guardar
        usuario.setNombre(nombre);
        usuario.setApp(app);
        usuario.setApm(apm);

        return repo.save(usuario);
    }

    private String normalizarParaCorreo(String texto) {
        return texto.trim().toLowerCase().replace(" ", "");
    }

    //BÚSQUEDAS
    public Usuario buscarPorId(Long idUsuario) {
        if (idUsuario == null) throw new RuntimeException("IdUsuario obligatorio");
        return repo.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no existe"));
    }

    public List<Usuario> buscarPorRol(Long idRol) {
        if (idRol == null) throw new RuntimeException("IdRol obligatorio");
        return repo.findByRol_IdRol(idRol);
    }

    public List<Usuario> buscarPorTexto(String q) {
        if (q == null || q.trim().isEmpty()) throw new RuntimeException("Texto de búsqueda obligatorio");
        String texto = q.trim();
        return repo.findByNombreContainingIgnoreCaseOrAppContainingIgnoreCaseOrApmContainingIgnoreCase(
                texto, texto, texto
        );
    }
    
    public Usuario editar(Long idUsuario, Usuario usuario) {

        if (idUsuario == null) throw new RuntimeException("IdUsuario obligatorio");

        Usuario usuarioBD = repo.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        // CAMPOS OBLIGATORIOS
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()
                || usuario.getApp() == null || usuario.getApp().trim().isEmpty()
                || usuario.getApm() == null || usuario.getApm().trim().isEmpty()
                || usuario.getFechaNacimiento() == null
                || usuario.getRol() == null
                || usuario.getRol().getIdRol() == null) {
            throw new RuntimeException("Todos los campos obligatorios deben llenarse");
        }

        String nombre = usuario.getNombre().trim();
        String app = usuario.getApp().trim();
        String apm = usuario.getApm().trim();

        // SOLO LETRAS
        if (!nombre.matches(SOLO_LETRAS)
                || !app.matches(SOLO_LETRAS)
                || !apm.matches(SOLO_LETRAS)) {
            throw new RuntimeException("Nombre y apellidos solo pueden contener letras");
        }

        // MAYOR DE 18
        int edad = Period.between(
                usuario.getFechaNacimiento().toLocalDate(),
                LocalDate.now()
        ).getYears();

        if (edad < 18) {
            throw new RuntimeException("Solo mayores de 18 años");
        }

        // DUPLICADO (solo si cambió nombre o apellidos)
        boolean cambioNombre = !usuarioBD.getNombre().equalsIgnoreCase(nombre)
                || !usuarioBD.getApp().equalsIgnoreCase(app)
                || !usuarioBD.getApm().equalsIgnoreCase(apm);

        if (cambioNombre && repo.existsByNombreAndAppAndApm(nombre, app, apm)) {
            throw new RuntimeException("Usuario duplicado");
        }

        // VALIDAR ROL
        Rol rolBD = rolRepo.findById(usuario.getRol().getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no existe"));

        // REGENERAR CORREO
        String correo = normalizarParaCorreo(nombre) + "." +
                normalizarParaCorreo(app) + "@enucom.com.mx";

        // ACTUALIZAR CAMPOS
        usuarioBD.setNombre(nombre);
        usuarioBD.setApp(app);
        usuarioBD.setApm(apm);
        usuarioBD.setSexo(usuario.getSexo());
        usuarioBD.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioBD.setRol(rolBD);
        usuarioBD.setCorreo(correo);

        return repo.save(usuarioBD);
    }


    // ELIMINAR
    public void eliminar(Long idUsuario) {
        if (idUsuario == null) throw new RuntimeException("IdUsuario obligatorio");
        repo.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no existe"));
        repo.deleteById(idUsuario);
    }
}

