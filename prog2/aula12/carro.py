class Carro:
    roda
    cor
    motor
    numero_portas
    numero_assentos
    ligado
    velocidade

    def ligar(self):
        print("Carro ligado ...")
        self.ligado = True
        self.motor = True

    def iluminar(self):
        print("Iluminando ...")

    def mover(self):
        if self.ligado == True:
            print("Se movendo ...")
            self.velocidade = 20
        else:
            print("O carro ainda esta desligado")