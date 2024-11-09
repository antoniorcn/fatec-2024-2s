class Trem:
    velocidade = 0
    maquinista = ""
    passageiros = 0
    direcao = "frente"
    assentos = 50

    def acelerar(self):
        self.velocidade += 0.01

    def frear(self):
        if self.velocidade > 0:
            self.velocidade -= 0.01

    def apitar(self):
        print("Piuiiii !!!")

    def trocar_direcao(self):
        if self.direcao == "frente":
            self.direcao = "tras"
        else:
            self.direcao = "frente"

