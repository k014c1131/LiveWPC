package liveWPCGui;

public interface liveWPC_toolbar_base {
	//�����l
	public static final int Default_number = 0;


	//�}�`�{�^���������ꂽ���̃A�N�V����
	//�}�`�ꗗ��\������
	public default void geometry_display(){}

	//�}�`�ꗗ����Y������}�`��I�����ꂽ�ꍇ�̃A�N�V����
	//���C����ʂɂ��̐}�`��\������
	//�����l�łǂ̐}�`�����f����
	//�����l�͐����`
	public default int selected_geometry(){	return Default_number;}

	//�A�C�R���{�^���������ꂽ���̃A�N�V����
	//�A�C�R���ꗗ��\������
	public default void icon_display(){}

	//�A�C�R���ꗗ����Y������A�C�R����I�����ꂽ�ꍇ�̃A�N�V����
	//���C����ʂɂ��̃A�C�R����\������
	//�����l�łǂ̃A�C�R�������f����
	//�����l�͓V�C(Todo:�v�l��)
	public default int selected_icon(){ return Default_number; }


	//�e�L�X�g�{�^���������ꂽ���̃A�N�V����
	//��ʂɃe�L�X�g��\������
	//�����l��[helloWorld](todo:�v�l��)

	public default void selected_text(){}

}
