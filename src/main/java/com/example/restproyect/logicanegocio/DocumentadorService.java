package com.example.restproyect.logicanegocio;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;

@Service
public class DocumentadorService {

	public void completarDocumento(Documento documento) {
		documento.setCantidadAnimales(this.getCantAnimales(documento.getDocumento()));
		documento.setCantidadMobs(this.getCantMobs(documento.getDocumento()));
	}

	private int getCantMobs(Document documento) {
		int result = 0;
		NodeList node = documento.getChildNodes().item(0).getChildNodes();
		FiltroAbs filtro = new FiltroNombre("mobs");
		for (int j = 0; j < node.getLength(); j++) {
			if (j % 2 != 0) {
				Node nodo = node.item(j);
				if (filtro.cumple(nodo)) {
					NodeList nodeMobs = node.item(j).getChildNodes();
					result = nodeMobs.getLength()/2;
				}
			}
		}
		return result;
	}

	private int getCantAnimales(Document documento) {
		int result = 0;
		NodeList node = documento.getChildNodes().item(0).getChildNodes();
		FiltroAbs filtro = new FiltroNombre("mobs");
		for (int j = 0; j < node.getLength(); j++) {
			if (j % 2 != 0) {
				Node nodo = node.item(j);
				if (filtro.cumple(nodo)) {
					NodeList nodeMobs = node.item(j).getChildNodes();
					for (int k = 0; k < nodeMobs.getLength() / 2; k++) {
						Node nodoMobs = nodeMobs.item(k * 2 + 1);
						NodeList submobs = nodoMobs.getChildNodes().item(11).getChildNodes();
						for (int i = 0; i < submobs.getLength(); i++) {
							if (i % 2 != 0) {
								Node nodoSubMob = submobs.item(i);
								result += Integer.parseInt(
										nodoSubMob.getAttributes().getNamedItem("startCountAnimals").getNodeValue());

							}
						}
					}
				}
			}
		}
		return result;
	}
}
