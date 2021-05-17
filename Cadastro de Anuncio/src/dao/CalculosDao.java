package dao;

import model.CalculosModel;
public class CalculosDao {


    /*
     * Método para calculo dos valores iniciais das variavéis antes do primeiro
     * compartilhamento
     * 
     * @Author Mateus Haverroth
     */

    double visualizacoes = (Investimento * 30);
    double cliques = (visualizacoes * 0.12);
    double compartilhamentos = (cliques * 0.15);

    /*
     * Definição das variaveis totais e atribuindo as mesmas valor inicial para
     * entrar no loop
     * 
     * @Author Mateus Haverroth
     */

    double quantidadeMaximaVisualicoes = visualizacoes;
    double quantidadeMaximaCompartilhamentos = compartilhamentos;
    double quantidadeMaximaCliques = cliques;

    /*
     * Criação do método onde ao gerar o compartilhamento de informações os valores
     * são recalculados e somados nas variavéis totais
     * 
     * @Author Mateus Haverroth
     */

    for (int i = 0; i < 4; i++) {

        visualizacoes = compartilhamentos * 40;
        cliques = (visualizacoes * 0.12);
        compartilhamentos = (cliques * 0.15);
        /*
         * for (int j = 0; j <= 3; j++) { if (j == 3) { continue; } else {
         * 
         * compartilhamentos = (cliques * 0.15); } }
         */

        cliquesTotal += cliques;
        visualizacoesTotal += visualizacoes;
        if (i >= 3) {
            continue;
        } else {
            quantidadeMaximaCompartilhamentos += compartilhamentos;
            }

    

