class ArvoreJaca:
    tronco = "Tronco marron"
    jacas = 2
    colmeia = True
    lanca_chamas = True
    esquilos_ferozes = 5
    tem_abelhas = True

    def ataque_colmeia(self):
        if self.colmeia:
            print("Usando ataque da colmeia")
        else:
            print("Acabou as comeias")

    def ataque_abelhas(self):
        if self.lanca_chamas == False:
            print("Ataque das abelhas não surtiu efeito")
            print("A arvore perdeu as abelhas")
        else:
            if self.tem_abelhas == True:
                print("Muito dano tirado do player")
                print("Mas a arvore perdeu as abelhas")
            else:
                print("A Arvore não tem mais abelhas")
        self.tem_abelhas = False        
        

    def ataque_jaca(self):
        if self.tem_abelhas == False:
            print("Atacando com a Jaca")
        else:
            print("A arvore deve primeiro atacar com as abelhas")
if __name__ == "__main__": 
    jaqueirine = ArvoreJaca()
    jacan = ArvoreJaca()
    jaqueira = jacan
    jaqueirine.tem_abelhas = False
    jacan.ataque_abelhas()
    jaqueira.ataque_abelhas()