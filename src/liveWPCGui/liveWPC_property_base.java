package liveWPCGui;

public interface liveWPC_property_base{
	//�����l
	public static final int DEFAULT_NUMBER = 0;

	//�J���[�p���b�g��\������
	//�}�`�A�����񋤒�
	public default void color_settings(){}


	//���ߓx�̃p���b�g��\������
	//�}�`�A�����񋤒�

	public default void ganma_settings(){}


	//�X���C�_�[��\������
	//�}�`�A�����񋤒�
	//����:�X���C�_�[�̃^�C�v(���ߓx�A�A�j���[�V�����̑��x�A�}�`��t�H���g�̃T�C�Y�c�Ȃ�)

	public default void size_settings(int type,int geometry_number){}


	//�t�H���g��ݒ肷��
	//�e�L�X�g����
	//����:�t�H���g��
	public default void font_settings(String font_name){}


	//�t�H���g�T�C�Y�w���\�����郁�\�b�h�B
	//�e�L�X�g����
	//����:�w�肷��t�H���g���������e�L�X�g�̃I�u�W�F�N�g
	//public default void fontsize_settings(object obj){}

	//�A�N�V�����g���K�[�A�A�j���[�V�����g���K�[���p�̗L���`�F�b�N�{�b�N�X
	//�}�`�A�����񋤒�
	//����:�ǂ���̃g���K�[���𔻕ʂ��邽�߂̐�

	public default void trigger_check(int checker){}


	//�A�j���[�V�����̑I���v���_�E����\��
	//����:�A�j���[�V�����̔ԍ�

	public default void animation_settings(){}






}

