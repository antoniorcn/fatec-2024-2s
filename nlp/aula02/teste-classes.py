class TesteValores():
    """
    Esta é uma classe de teste
    """
    outra_variavel = 30
    LINHA_POR_PAGINA = 80

    def __init__(self):
        self.minha_variavel = 20
        self.__valores = 100

    def mostrar_tudo(self):
        print("Valores")
        print("Minha variavel: ", self.minha_variavel)
        print("Valores: ", self.__valores)
        print("Outra Variavel: ", self.outra_variavel)


t1 = TesteValores()
t1.mostrar()