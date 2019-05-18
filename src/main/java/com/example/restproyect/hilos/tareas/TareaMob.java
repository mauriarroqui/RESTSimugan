package com.example.restproyect.hilos.tareas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.destete.EstadoDestete;
import com.example.restproyect.states.objetosinternos.mobs.VariacionMob;
import com.example.restproyect.states.objetosinternos.mobs.VariacionesMobs;

public class TareaMob extends AbsTarea {

	private List<VariacionesMobs> variaciones;

	public TareaMob(List<VariacionesMobs> variaciones, FiltroAbs filtro, Documento documento, Integer numero) {
		this.variaciones = variaciones;
		this.filtro = filtro;
		this.doc = documento;
		this.numero = numero;

	}

	public String getMonth(int i) {
		String result = "";
		switch (i) {
		case 0:
			result = "January";
			break;
		case 1:
			result = "February";
			break;
		case 2:
			result = "March";
			break;
		case 3:
			result = "April";
			break;
		case 4:
			result = "May";
			break;
		case 5:
			result = "June";
			break;
		case 6:
			result = "July";
			break;
		case 7:
			result = "August";
			break;
		case 8:
			result = "September";
			break;
		case 9:
			result = "October";
			break;
		case 10:
			result = "November";
			break;
		case 11:
			result = "December";
			break;

		}
		return result;
	}

	@Override
	public ArrayList<Documento> call() {
		// TODO Auto-generated method stub
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		final int cantMobs = variaciones.size();
		final int cantVariaciones = variaciones.get(0).getVariacion().size();
		System.out.println("cantidad de mobs = " + cantMobs + " cantidad de Variaciones = " + cantVariaciones);
		// este for loopea las variaciones obtenidas de la reactWeb
		for (int indexVariaciones = 0; indexVariaciones < cantVariaciones; indexVariaciones++) {
			Documento doc = new Documento(this.doc.getDocumento());
			Document insertDoc = doc.clonarDocumento();

			doc.setDocumento(insertDoc);

			NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();
			// este for busca el tag <MOBS>
			for (int j = 0; j < node.getLength(); j++) {
				if (j % 2 != 0) {
					Node nodo = node.item(j);
					if (filtro.cumple(nodo)) {
						NodeList nodeMobs = node.item(j).getChildNodes();
						// este for recorre los mobs y aca deberia modificar todos los tags y atributos
						for (int k = 0; k < variaciones.size(); k++) {
								Node nodoMobs = nodeMobs.item(k*2+1);
								VariacionMob variacion = variaciones.get(k).getVariacion().get(indexVariaciones); // k
																														// -
																														// 1
																														// para
																														// compensar
																														// el
																														// problema
																														// de
																														// k%2
								nodoMobs.getAttributes().getNamedItem("enableCrop_stubble")
										.setNodeValue(String.valueOf(variacion.isDiferidosEnable()));
								nodoMobs.getAttributes().getNamedItem("enableStockPilled")
										.setNodeValue(String.valueOf(variacion.isRastrojoEnable()));

								nodoMobs.getAttributes().getNamedItem("service")
										.setNodeValue(String.valueOf(variacion.getParamGenerales().get(0)));
								nodoMobs.getAttributes().getNamedItem("repositionPercent")
										.setNodeValue(String.valueOf(variacion.getParamGenerales().get(1)));
								nodoMobs.getAttributes().getNamedItem("minInServiceWeight")
										.setNodeValue(String.valueOf(variacion.getParamGenerales().get(2)));

								Node nodoPastura = nodoMobs.getChildNodes().item(1);
								Node nodoSilage = nodoMobs.getChildNodes().item(3);
								Node nodoGrain = nodoMobs.getChildNodes().item(5);
								Node nodoDiferido = nodoMobs.getChildNodes().item(7);
								Node nodoRastrojo = nodoMobs.getChildNodes().item(9);
								Node nodoWeaning = nodoMobs.getChildNodes().item(13);
								for (int i = 0; i < 12; i++) {
									nodoPastura.getAttributes().getNamedItem(this.getMonth(i))
											.setNodeValue(String.valueOf(variacion.getPastureAllow().get(i).getValue()));
									nodoGrain.getAttributes().getNamedItem(this.getMonth(i))
											.setNodeValue(String.valueOf(variacion.getSilageAllow().get(i).getValue()));
									nodoSilage.getAttributes().getNamedItem(this.getMonth(i))
											.setNodeValue(String.valueOf(variacion.getGrainAllow().get(i).getValue()));
									nodoDiferido.getAttributes().getNamedItem(this.getMonth(i))
											.setNodeValue(String.valueOf(variacion.getStockAllow().get(i).getValue()));
									nodoRastrojo.getAttributes().getNamedItem(this.getMonth(i))
											.setNodeValue(String.valueOf(variacion.getCropAllow().get(i).getValue()));

								}

								// ---weaning
								if (nodoWeaning.getAttributes() != null) {
									nodoWeaning.getAttributes().getNamedItem("enableCrop_stubble").setNodeValue(
											String.valueOf(variacion.getWeaningMobs().isDiferidosEnable()));
									nodoWeaning.getAttributes().getNamedItem("enableStockPilled").setNodeValue(
											String.valueOf(variacion.getWeaningMobs().isRastrojoEnable()));
									Node nodoWeaningPastura = nodoWeaning.getChildNodes().item(1);
									Node nodoWeaningSilage = nodoWeaning.getChildNodes().item(3);
									Node nodoWeaningGrain = nodoWeaning.getChildNodes().item(5);
									Node nodoWeaningDiferido = nodoWeaning.getChildNodes().item(7);
									Node nodoWeaningRastrojo = nodoWeaning.getChildNodes().item(9);
									for (int i = 0; i < 12; i++) {
										nodoWeaningPastura.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(
												String.valueOf(variacion.getWeaningMobs().getPastureAllow().get(i).getValue()));
										nodoWeaningGrain.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(
												String.valueOf(variacion.getWeaningMobs().getSilageAllow().get(i).getValue()));
										nodoWeaningSilage.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(
												String.valueOf(variacion.getWeaningMobs().getGrainAllow().get(i).getValue()));
										nodoWeaningDiferido.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(
												String.valueOf(variacion.getWeaningMobs().getStockAllow().get(i).getValue()));
										nodoWeaningRastrojo.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(
												String.valueOf(variacion.getWeaningMobs().getCropAllow().get(i).getValue()));

									}
								}

								NodeList submobs = nodoMobs.getChildNodes().item(11).getChildNodes();
								for (int i = 0; i < submobs.getLength(); i++) {
									if (i % 2 != 0) {
										Node nodoSubMob = submobs.item(i);
										System.out.println( "------>" +  variacion.getSubmobs().get(i/2));
										String chota = String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(0));
										nodoSubMob.getAttributes().getNamedItem("weaning").setNodeValue(
												String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(0)));
										nodoSubMob.getAttributes().getNamedItem("startCountAnimals").setNodeValue(
												String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(1)));
										nodoSubMob.getAttributes().getNamedItem("submobSwMax").setNodeValue(
												String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(2)));
										nodoSubMob.getAttributes().getNamedItem("submobSwMean").setNodeValue(
												String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(3)));
										nodoSubMob.getAttributes().getNamedItem("submobSwMin").setNodeValue(
												String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(4)));

										NodeList nodoweaner = nodoSubMob.getChildNodes().item(1).getChildNodes();

										nodoweaner.item(1).getAttributes().getNamedItem("amount").setNodeValue(
												String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(5)));
										nodoweaner.item(3).getAttributes().getNamedItem("amount").setNodeValue(
												String.valueOf(variacion.getSubmobs().get(i/2).getValores().get(6)));

									}
								}

								
						}
					}
				}
			}
			documentosGenerados.add(doc);
		}
		
		return documentosGenerados;
	}

}
