
package com.clarisa.service;

import com.clarisa.model.CufeRequest;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CufeService {

    public String generateCUFE(CufeRequest request) {
        String data = request.getNumFac() + request.getFecFac() + request.getHorFac() +
                      request.getValFac() + request.getCodImp1() + request.getValImp1() +
                      request.getCodImp2() + request.getValImp2() + request.getCodImp3() + request.getValImp3() +
                      request.getValTot() + request.getNitFE() + request.getNumAdq() + request.getCiTec() +
                      request.getTipoAmbiente();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-384");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar el hash SHA-384", e);
        }
    }
}
