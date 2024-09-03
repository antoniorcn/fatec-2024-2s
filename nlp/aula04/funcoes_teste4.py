"""
    Teste de função
"""
def mostrar_na_tela(**parametros):
    """
        Mostrar todos os valores passados como 
        parametros na tela
        parametros = {nome:"Joao Silva", telefone:"(11) 1111-1111", 
                rg:"11.111.111-1"}
    """
    # for chave in parametros.keys():
    #     valor = parametros[chave]
    #     print(chave, ": ", valor)
    for item in parametros.items():
        print(item[0], ": ", item[1])


mostrar_na_tela(nome="Joao Silva", telefone="(11) 1111-1111",
                rg="11.111.111-1", nascimento="05/06/2000")