import java.awt.*
import javax.swing.*

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("Cafeteria Dev - Sistema de Pedidos")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Dimension(420, 480)
        frame.setLocationRelativeTo(null) // Centraliza a janela na tela

        val cardLayout = CardLayout()
        val mainPanel = JPanel(cardLayout)

        val telaPedido = JPanel()
        telaPedido.layout = BoxLayout(telaPedido, BoxLayout.Y_AXIS)
        telaPedido.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

        val lblTitulo1 = JLabel("☕ Faça seu Pedido")
        lblTitulo1.font = Font("Arial", Font.BOLD, 20)
        lblTitulo1.alignmentX = Component.LEFT_ALIGNMENT

        val lblNome = JLabel("Seu Nome:")
        lblNome.alignmentX = Component.LEFT_ALIGNMENT
        val txtNome = JTextField(15)
        txtNome.maximumSize = Dimension(Int.MAX_VALUE, 32)
        txtNome.alignmentX = Component.LEFT_ALIGNMENT

        val lblCafe = JLabel("Escolha a Bebida:")
        lblCafe.alignmentX = Component.LEFT_ALIGNMENT
        val comboCafe = JComboBox(
            arrayOf(
                "Café Expresso - R$ 6,00",
                "Cappuccino - R$ 10,00",
                "Café Gelado - R$ 12,00"
            )
        )
        comboCafe.maximumSize = Dimension(Int.MAX_VALUE, 32)
        comboCafe.alignmentX = Component.LEFT_ALIGNMENT

        val lblQtd = JLabel("Quantidade:")
        lblQtd.alignmentX = Component.LEFT_ALIGNMENT
        val spinnerQtd = JSpinner(SpinnerNumberModel(1, 1, 20, 1))
        spinnerQtd.maximumSize = Dimension(Int.MAX_VALUE, 32)
        spinnerQtd.alignmentX = Component.LEFT_ALIGNMENT

        val btnAvancar = JButton("Ver Resumo do Pedido")
        btnAvancar.alignmentX = Component.LEFT_ALIGNMENT
        btnAvancar.font = Font("Arial", Font.BOLD, 14)


        telaPedido.add(lblTitulo1)
        telaPedido.add(Box.createRigidArea(Dimension(0, 15)))
        telaPedido.add(lblNome)
        telaPedido.add(Box.createRigidArea(Dimension(0, 5)))
        telaPedido.add(txtNome)
        telaPedido.add(Box.createRigidArea(Dimension(0, 15)))
        telaPedido.add(lblCafe)
        telaPedido.add(Box.createRigidArea(Dimension(0, 5)))
        telaPedido.add(comboCafe)
        telaPedido.add(Box.createRigidArea(Dimension(0, 15)))
        telaPedido.add(lblQtd)
        telaPedido.add(Box.createRigidArea(Dimension(0, 5)))
        telaPedido.add(spinnerQtd)
        telaPedido.add(Box.createRigidArea(Dimension(0, 25)))
        telaPedido.add(btnAvancar)

        val telaResumo = JPanel()
        telaResumo.layout = BoxLayout(telaResumo, BoxLayout.Y_AXIS)
        telaResumo.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

        val lblTitulo2 = JLabel("📋 Resumo do Pedido")
        lblTitulo2.font = Font("Arial", Font.BOLD, 20)
        lblTitulo2.alignmentX = Component.LEFT_ALIGNMENT

        val lblResumoNome = JLabel("Cliente: ")
        lblResumoNome.font = Font("Arial", Font.PLAIN, 15)
        lblResumoNome.alignmentX = Component.LEFT_ALIGNMENT

        val lblResumoItem = JLabel("Item: ")
        lblResumoItem.font = Font("Arial", Font.PLAIN, 15)
        lblResumoItem.alignmentX = Component.LEFT_ALIGNMENT

        val lblResumoQtd = JLabel("Quantidade: ")
        lblResumoQtd.font = Font("Arial", Font.PLAIN, 15)
        lblResumoQtd.alignmentX = Component.LEFT_ALIGNMENT

        val lblResumoTotal = JLabel("Total: R$ 0,00")
        lblResumoTotal.font = Font("Arial", Font.BOLD, 18)
        lblResumoTotal.foreground = Color(0, 120, 0) // Cor verde
        lblResumoTotal.alignmentX = Component.LEFT_ALIGNMENT

        val btnVoltar = JButton("← Alterar ou Fazer Novo Pedido")
        btnVoltar.alignmentX = Component.LEFT_ALIGNMENT


        telaResumo.add(lblTitulo2)
        telaResumo.add(Box.createRigidArea(Dimension(0, 20)))
        telaResumo.add(lblResumoNome)
        telaResumo.add(Box.createRigidArea(Dimension(0, 10)))
        telaResumo.add(lblResumoItem)
        telaResumo.add(Box.createRigidArea(Dimension(0, 10)))
        telaResumo.add(lblResumoQtd)
        telaResumo.add(Box.createRigidArea(Dimension(0, 15)))
        telaResumo.add(JSeparator())
        telaResumo.add(Box.createRigidArea(Dimension(0, 15)))
        telaResumo.add(lblResumoTotal)
        telaResumo.add(Box.createRigidArea(Dimension(0, 25)))
        telaResumo.add(btnVoltar)


        mainPanel.add(telaPedido, "TELA_PEDIDO")
        mainPanel.add(telaResumo, "TELA_RESUMO")


        btnAvancar.addActionListener {
            val nome = txtNome.text.trim()

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Por favor, digite seu nome antes de continuar!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
                )
                return@addActionListener
            }

            val indexItem = comboCafe.selectedIndex
            val nomeItem = when (indexItem) {
                0 -> "Café Expresso"
                1 -> "Cappuccino"
                else -> "Café Gelado"
            }
            val precoUnitario = when (indexItem) {
                0 -> 6.0
                1 -> 10.0
                else -> 12.0
            }
            val qtd = spinnerQtd.value as Int
            val total = precoUnitario * qtd

            lblResumoNome.text = "Cliente: $nome"
            lblResumoItem.text = "Item: $nomeItem"
            lblResumoQtd.text = "Quantidade: $qtd x R$ %.2f".format(precoUnitario)
            lblResumoTotal.text = "Total a Pagar: R$ %.2f".format(total)

            cardLayout.show(mainPanel, "TELA_RESUMO")
        }

        btnVoltar.addActionListener {
            cardLayout.show(mainPanel, "TELA_PEDIDO")
        }

        frame.add(mainPanel)
        frame.isVisible = true
    }
}