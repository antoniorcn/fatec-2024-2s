import pygame
from pygame.locals import QUIT, MOUSEBUTTONDOWN
# Valor 1 - Jogador 1      2 - Jogador 2      0 - Vazio
matriz = [
# colunas    0  1  2
            [0, 0, 0],      # linha 0
            [0, 0, 0],      # linha 1
            [0, 0, 0]       # linha 2
]
pygame.init()
screen = pygame.display.set_mode( (800, 600), 0, 32 )

img_x_original = pygame.image.load("x.png").convert_alpha()
img_o_original = pygame.image.load("o.png").convert_alpha()

largura = 200
altura = 150
inicio_x = 100
inicio_y = 100
sair = False

img_x = pygame.transform.scale(img_x_original, (largura, altura))
img_o = pygame.transform.scale(img_o_original, (largura, altura))

while not sair:
    # Calcular as regras
    # Mostrar na tela
    screen.fill( (0, 0, 0) )        # Limpar a tela
    for linha in range(3):
        y = inicio_y + (linha * altura)
        for coluna in range(3):
            x = inicio_x + (coluna * largura)
            celula = matriz[linha][coluna]
            expessura = 3
            pygame.draw.rect(screen, (255, 255, 0),
                            ( (x, y), (largura, altura) ), expessura  )
            if celula == 1:
                screen.blit(img_x, (x, y))
            elif celula == 2:
                screen.blit(img_o, (x, y))

    pygame.display.update()         # Atualiza a tela
    # Capturar os eventos
    lista = pygame.event.get()
    # if len(lista) > 0:
    #     print(lista)
    for event in lista:
        if event.type == QUIT:
            sair = True
        elif event.type == MOUSEBUTTONDOWN:
            if event.button == 1:
                x = event.pos[0]
                y = event.pos[1]
                # x = inicio_x + (coluna * largura)
                coluna = (x - inicio_x) // largura
                linha = (y - inicio_y) // altura
                print(f"""Mouse apertado x:({x}) y:({y})
                       coluna:({coluna}) linha:({linha})""")
                if coluna >=0 and coluna <= 2 and linha >=0 and linha <= 2:
                    celula = matriz[linha][coluna]
                    nova_celula = 0
                    if celula == 0:
                        nova_celula = 1
                    elif celula == 1:
                        nova_celula = 2
                    matriz[linha][coluna] = nova_celula
